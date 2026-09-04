# Wend Reimagined

## About
I wanted to put my own spin on LinkedIn's Wend game by turning it into a theme-based word puzzle game. 
I created Wend Reimagined as a personal project to strengthen my skills in Java, Spring Boot, MySQL, REST APIs, 
and TypeScript while building something fun and interactive.

## Features
- Daily puzzle
- Multiple themes
- Easy, Medium, and Hard difficulties
- Interactive word selection
- Puzzle validation

## Tech Stack
- React
- TypeScript
- Vite
- Java
- Spring Boot
- MySQL
- REST API

## How It Works

Wend Reimagined uses a React and TypeScript frontend that communicates with a Spring Boot backend through REST APIs. 
The backend retrieves themes, puzzles, and words from a MySQL database and sends the data to the frontend.

When the game loads, the frontend requests the available theme and puzzle data from the backend. The puzzle grid and 
associated words are then displayed for the player to interact with.

**Flow:**

React/TypeScript → Spring Boot REST API → MySQL


## Database

The project uses MySQL to store themes, puzzles, and words.

* **Theme** stores the puzzle theme, such as Disney or Space.
* **Puzzle** belongs to a theme and contains the puzzle's difficulty and grid.
* **Word** belongs to a puzzle and stores the word and the cell path used to identify its location on the puzzle grid.

The relationships between the entities are:

**Theme → Puzzle:** One-to-Many
**Puzzle → Word:** One-to-Many


## Data Initialization

The application uses a Spring Boot `CommandLineRunner` called `DataInitializer` to populate the database with the initial game data.

On startup, the initializer checks whether the required themes and puzzles already exist. If they do not exist, it creates them along with their associated words and cell paths.

The initializer includes:

* 2 themes: Disney and Space
* 6 puzzles across Easy, Medium, and Hard difficulties
* 20 words with their corresponding puzzle paths

The initializer checks for existing data before creating new records, preventing duplicate data when the application is restarted.


## Running the Project

### Backend

1. Open the backend project in your IDE.
2. Make sure MySQL is running, and the `wend` database is available.
3. Start the Spring Boot application.
4. The backend will run on:

`http://localhost:8080`

The `DataInitializer` will automatically check and initialize the required game data when the application starts.

### Frontend

1. Open a terminal in the frontend project.
2. Install the dependencies:

```bash
npm install
```

3. Start the Vite development server:

```bash
npm run dev
```

4. Open the local URL provided by Vite in your browser.

The frontend communicates with the Spring Boot backend running on port 8080.

##Improvements
- Have the undo button and Hint button work
- Get the How To Play drop-down to actually work
- Have the puzzles change daily

## Screenshots
<img width="733" height="796" alt="image" src="https://github.com/user-attachments/assets/56a952bd-7915-4652-9a3f-e317ec640f6b" />

<img width="733" height="796" alt="image" src="https://github.com/user-attachments/assets/004396fd-5e9f-4a12-a25b-f654ef5a3e7c" />


