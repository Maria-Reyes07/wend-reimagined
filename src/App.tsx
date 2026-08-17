import { useEffect, useState } from 'react';
import React  from 'react';
import './App.css';

const checkCircle =
  'https://www.figma.com/api/mcp/asset/64de5062-3345-4948-9d19-1718c595269a.svg';

const checkIcon =
  'https://www.figma.com/api/mcp/asset/5ea4da76-2d81-4ed3-bfab-14621579ae0c.svg';

type Word = {
  id: number;
  text: string;
  path: number[];
};

function Correct() {
  return (
    <div className="correct">
      <img className="correct-circle" src={checkCircle} alt="" />
      <img className="correct-check" src={checkIcon} alt="" />
    </div>
  );
}
function App() {
  const [theme, setTheme] = useState('');
  const [puzzle, setPuzzle] = useState<string[]>([]);
  const [words, setWords] = useState<Word[]>([]);
  const [selectedLetters, setSelectedLetters] = useState<string[]>([]);
  const [selectedCells, setSelectedCells] = useState<number[]>([]);
  const [isSelecting, setIsSelecting] = useState(false);
  const [foundWords, setFoundWords] = useState<number[]>([]);
  const [foundCells, setFoundCells] = useState<number[]>([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/themes')
      .then(response => response.json())
      .then(data => {
        setTheme(data[0].name);
      })
      .catch(error => {
        console.error('Error fetching theme:', error);
      });

    fetch('http://localhost:8080/api/puzzles')
      .then(response => response.json())
      .then(data => {
        const puzzleGrid = data[0].grid
          .replaceAll('/', '')
          .split('');

        setPuzzle(puzzleGrid);
        setWords(data[0].words);
      })
      .catch(error => {
        console.error('Error fetching puzzle:', error);
      });
  }, []);

  const canSelectCell = (index: number) => {
  if (selectedCells.length === 0) {
    return true;
  }

  const lastIndex = selectedCells[selectedCells.length - 1];

  const lastRow = Math.floor(lastIndex / 5);
  const lastColumn = lastIndex % 5;

  const currentRow = Math.floor(index / 5);
  const currentColumn = index % 5;

  const rowDifference = Math.abs(currentRow - lastRow);
  const columnDifference = Math.abs(currentColumn - lastColumn);

  return (
    (rowDifference === 1 && columnDifference === 0) ||
    (rowDifference === 0 && columnDifference === 1)
  );
};

const checkForMatch = () => {
  const selectedPath = selectedCells;

  const matchedWord = words.find(word =>
    JSON.stringify(word.path) === JSON.stringify(selectedPath)
  );

  if (matchedWord) {
    console.log('MATCH!', matchedWord.text);

    setFoundWords([...foundWords, matchedWord.id]);

    // Keep these cells highlighted
    setFoundCells([...foundCells, ...matchedWord.path]);

    // Clear the temporary selection
    setSelectedCells([]);
  } else {
    console.log('No match');
    setSelectedCells([]);
  }
};

const sortedWords = [...words].sort(
  (a, b) => a.text.length - b.text.length
);

  return (
    <div>
      <div className="NavBar">
        <h1>Wend : Theme</h1>
      </div>

      <div className="back-ground">
        <h1>THEME: {theme}</h1>

        <div className="puzzle-box"
        onMouseUp={() => {
          setIsSelecting(false);
          checkForMatch();
        }}>
          {puzzle.map((letter, index) => {
            if (letter !== '#') {
              return (
                <div
                  className="child"
                  key={index}
                  onMouseDown={() => {
                    setIsSelecting(true);
                    setSelectedCells([index]);
                  }}
              onMouseEnter={() => {
                if (isSelecting && canSelectCell(index)) {
                  if (!selectedCells.includes(index)) {
                    setSelectedCells([...selectedCells, index]);
                  }
                }
              }}
                >
                <div
                  className={
                    selectedCells.includes(index) || foundCells.includes(index)
                      ? 'selected-cell'
                      : ''
                  }
                >
                  {letter}
                </div>
                </div>
              );
            }

            const hasLeft =
              index % 5 !== 0 && puzzle[index - 1] === '#';

            const hasRight =
              index % 5 !== 4 && puzzle[index + 1] === '#';

            if (hasLeft && hasRight) {
              return <div className="blackout-middle" key={index}></div>;
            }

            if (!hasLeft && hasRight) {
              return <div className="blackout-left" key={index}></div>;
            }

            if (hasLeft && !hasRight) {
              return <div className="blackout-right" key={index}></div>;
            }

            return <div className="blackout-single" key={index}></div>;
          })}
        </div>

        {/* <!-- Letter popup --> */}
        <div className="letter-popup">
          {selectedCells.map((cellIndex) => (
            <div className="found-letter" key={cellIndex}>
              {puzzle[cellIndex]}
            </div>
          ))}
        </div>

      {/* <!-- Word Length --> */}
        {sortedWords.map((word) => {
          const isFound = foundWords.includes(word.id);

          return (
            <div className="letter-placeholder" key={word.id}>
              {word.text.split('').map((letter, index) => (
                <div
                  className={isFound ? 'found-letter' : 'empty-circle'}
                  key={index}
                >
                  {isFound ? letter.toUpperCase() : ''}
                </div>
              ))}

              {isFound && <Correct />}
            </div>
          );
        })}

       <div className="button">
        {/* <!-- Undo Button --> */}
        <div className="undo-button">Undo</div>
        {/* <!-- Hint Button --> */}
        <div className="hint-button">Hint</div>
       </div>
       {/* <!-- How to play --> */}
          <div className="how-to">How to play
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
              <path fillRule="evenodd" clipRule="evenodd" d="M1.55277 6.77638C1.67627 6.52939 1.9766 6.42928 2.22359 6.55277L7.99999 9.44097L13.7764 6.55277C14.0234 6.42928 14.3237 6.52939 14.4472 6.77638C14.5707 7.02337 14.4706 7.32371 14.2236 7.4472L8.22359 10.4472C8.08283 10.5176 7.91714 10.5176 7.77638 10.4472L1.77638 7.4472C1.52939 7.32371 1.42928 7.02337 1.55277 6.77638Z" fill="black"/>
            </svg>
          </div>
       {/* <!-- Keyboard Controls --> */}
        <div className="control">Keyboard Controls
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
            <path fillRule="evenodd" clipRule="evenodd" d="M1.55277 6.77638C1.67627 6.52939 1.9766 6.42928 2.22359 6.55277L7.99999 9.44097L13.7764 6.55277C14.0234 6.42928 14.3237 6.52939 14.4472 6.77638C14.5707 7.02337 14.4706 7.32371 14.2236 7.4472L8.22359 10.4472C8.08283 10.5176 7.91714 10.5176 7.77638 10.4472L1.77638 7.4472C1.52939 7.32371 1.42928 7.02337 1.55277 6.77638Z" fill="black"/>
          </svg>
        </div>
      </div>
    </div>
  );
}

export default App;