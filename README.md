# FinalProj – Quiz System

## 📘 Description
A Java-based quiz system with login authentication, instructor tools, and student score tracking.

## ✨ Features
- **Login System**
  - Authenticates users from `UsersInfo.txt`
  - Allows up to 3 login attempts
  - Special instructor account with extra privileges

- **Instructor Tools**
  - Register new students
  - Add True/False quiz questions
  - View statistics (lowest, highest, average scores)

- **Student Features**
  - Take a 10-question True/False quiz
  - Randomized question selection
  - Score reporting and tracking

- **Reporting**
  - Saves results to a file
  - Tracks scores in memory for stats

## File Structure
- `UsersInfo.txt` – Stores user information (first name, last name, username, password, role)
- `TestBank.txt` – Stores quiz questions
- `Answers.txt` – Stores corresponding answers
- `FinalProj.java` – Main program source code

## How to Run
1. Clone this repository  
   ```bash
   git clone https://github.com/yourusername/FinalProj.git
