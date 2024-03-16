# CoinMachine

## Introduction

This project was conceived with the aim of fulfilling all the requirements proposed for the challenge presented by the company Asseco. It is based on a simulation of a coin machine with two ends, where you can either insert coins (operation "P") or receive them, if another person inserts them (operation "R").


## How To Run The Project

To run the project, it's quite simple. We just need to execute the command <code>docker compose up</code> in the root of the project. This will pull the designated Docker image created specifically for this project (which resides on Docker Hub) and run the container, making the project available.

## How To Test It

Execute the endpoint "/coins" on the localhost and send a payload containing the necessary information for each person.
Example of a Payload:
```json
{
    "rightPerson": ["P","P","R"],
    "leftPerson": ["P","R","R"]
}
```
Then it will respond with how many coins each person gets at the end (remembering that each person starts with 3 coins).
Expected response:
```json
{
    "rightPerson": 4,
    "leftPerson": 8
}
```