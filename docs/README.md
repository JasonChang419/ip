# JohnChatbot User Guide

![Ui screenshot](https://jasonchang419.github.io/ip/Ui.png)

**JohnChatbot** is a Desktop App that supports a Command Line Interface(CLI) while
utilizing a Graphical User Interface (GUI) for ease of user experience. Given below are
instructions on how to use it to the fullest.

> [!NOTE] About the Command Format:
Words wrapped in curly braces and `{UPPER_CASE}` are parameters to be supplied by the user
e.g. `todo {NAME}`, `NAME` is a parameter which can be used as `todo Task 1`.



## Adding tasks
JohnChatbot supports 3 types of tasks, all of which can be marked as done or not done: 
1. Todo tasks
2. Deadline tasks
3. Event tasks


### Adding todo tasks
Adds a task that only contains the name of the task.

Command: `todo {NAME}`

Example:
- `todo Complete Assignment 1`

```
Understood. Added the following Task:
     [T] [ ] Complete Assignment
There are 1 items on the list.
```


### Adding deadline tasks
Adds a task that contains a date as a deadline.

> [!NOTE]
Deadlines should follow the format YYYY-MM-DD

Command: `deadline {NAME} /by {DATE}`

Example:
- `deadline Return book /by 2025-09-18`

```
Understood. Added the following Task:
     [D] [ ] Return book  (By: Sep 18 2025)
There are 1 items on the list.
```


### Adding event tasks
Adds a task that contains a start and end time, as well as the beginning and end dates."

> [!NOTE]
Times should should follow the format YYYY-MM-DD HHmm

Command: `event {NAME} /from {START_TIME} /to {END_TIME}

Example:
- `event Book Fair /from 2025-09-20 2000 /to 2025-09-20 2230`

```
Understood. Added the following Task:
     [E] [ ] Book Fair  (from: Sep 20 2025 8.00pm to: Sep 20 2025 10.30pm)
There are 1 items on the list.
```

## Marking tasks
Marks the task at the given index as done

Command: `mark {INDEX}`


## Unmarking tasks
Marks the task at the given index as not done
A task added to the task list is marked as not done by default

Command: `unmark {INDEX}`

## Deleting tasks
Removes the task at the given index

Command: `delete {INDEX}`

## Listing tasks
Displays all tasks on the list
as well as their current order

Command: `list `

```
1.[T] [X] Complete Assignment
2.[D] [ ] Return book  (By: Sep 18 2025)
3.[E] [ ] Book Fair  (from: Sep 20 2025 8.00pm to: Sep 20 2025 10.30pm)
```

## Finding tasks
Finds all tasks that contain a given keyword in the name

Command: `find {KEYWORD}`

Example:
- `find book`

```
Here are the tasks that contain that keyword: 
2. [D] [ ] Return book  (By: Sep 18 2025)
3. [E] [ ] Book Fair  (from: Sep 20 2025 8.00pm to: Sep 20 2025 10.30pm)
```

## Viewing help
Shows a message that contains all of the available commands

Command: `help`

## Closing the program
Closes the program 

> [!TIP]
This automatically saves the current list

Command: `bye`
