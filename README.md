# 🚢 Java Battleship Game

<div align="center">
  <h3>A classic Battleship game implementation in Java</h3>
  <p>Play against the computer in this text-based naval warfare strategy game!</p>
</div>

<div align="center">
  <!-- You can add badges here -->
  <img src="https://img.shields.io/badge/language-Java-orange.svg">
  <img src="https://img.shields.io/badge/platform-CLI-lightgrey.svg">
  <img src="https://img.shields.io/badge/game-Single%20Player-blue.svg">
</div>

<br>

<p align="center">
  <a href="#-features">Features</a> •
  <a href="#-requirements">Requirements</a> •
  <a href="#-installation">Installation</a> •
  <a href="#-how-to-play">How To Play</a> •
  <a href="#-game-rules">Game Rules</a> •
  <a href="#-structure">Structure</a>
</p>

## 🎮 Features

<ul>
  <li>Text-based user interface</li>
  <li>Single player vs intelligent computer opponent</li>
  <li>Classic Battleship gameplay mechanics</li>
  <li>Traditional 10x10 game board</li>
  <li>Standard fleet of ships:
    <ul>
      <li>Carrier (5 spaces)</li>
      <li>Battleship (4 spaces)</li>
      <li>Cruiser (3 spaces)</li>
      <li>Submarine (3 spaces)</li>
      <li>Destroyer (2 spaces)</li>
    </ul>
  </li>
</ul>

## 💻 Requirements

<ul>
  <li>Java Development Kit (JDK) 8 or higher</li>
  <li>Command line interface</li>
</ul>

## 📥 Installation

1. Clone the repository
```bash
git clone https://github.com/Drip7789/battleship.git
cd battleship
```

2. Compile the source files
```bash
javac *.java
```

## 🎯 How to Play

1. Start the game:
```bash
java Game
```

2. Place your ships:
<table>
  <tr>
    <th>Input Format</th>
    <th>Example</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>[LETTER][NUMBER],[DIRECTION]</td>
    <td>B3,east</td>
    <td>Places ship at B3 facing east</td>
  </tr>
</table>

- Valid positions: A-J (rows), 1-10 (columns)
- Valid directions: north, south, east, west

3. Board symbols:
<table>
  <tr>
    <th>Symbol</th>
    <th>Meaning</th>
  </tr>
  <tr>
    <td>*</td>
    <td>Empty water</td>
  </tr>
  <tr>
    <td>S</td>
    <td>Your ship</td>
  </tr>
  <tr>
    <td>H</td>
    <td>Hit</td>
  </tr>
  <tr>
    <td>X</td>
    <td>Miss</td>
  </tr>
</table>

## 📋 Game Rules

<ol>
  <li>Ships must be placed completely within the board boundaries</li>
  <li>Ships cannot overlap with each other</li>
  <li>Ship positions are fixed after placement</li>
  <li>Players alternate turns attacking enemy grid positions</li>
  <li>Game ends when all ships of one player are sunk</li>
</ol>

## 📁 Structure

```
battleship/
├── Board.java     # Game board logic and state management
├── Game.java      # Main game controller and UI
├── Position.java  # Coordinate system handling
├── Ship.java      # Ship placement and status tracking
└── README.md
```

<div align="center">
  <h2>🤝 Contributing</h2>
  <p>Contributions are welcome! Feel free to fork and submit pull requests.</p>
</div>

<div align="center">
  <h2>📝 License</h2>
  <p>This project is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International - see the <a href="LICENSE">LICENSE</a> file for details.</p>
</div>

---
<div align="center">
  Made with ❤️ by <a href="https://github.com/Drip7789">Drip7789</a>
</div>
