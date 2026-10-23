# MiniBank — Core Java Console Project

## Requirements
- JDK 17 or newer
- Terminal / VS Code / IntelliJ IDEA

## Compile
From the project root:

```bash
javac -d out $(find src -name "*.java")
```

## Run
```bash
java -cp out MiniBank
```

## Build runnable JAR
```bash
printf "Main-Class: MiniBank\n" > manifest.txt
jar cfm MiniBank.jar manifest.txt -C out .
java -jar MiniBank.jar
```

## Features
- Console menu, account opening, deposit, withdrawal, transfer and statement
- Savings, current and fixed-deposit account types
- Interfaces, abstract class, inheritance and polymorphism
- Validation helpers, command parser, custom annotations and reflection validator
- Custom checked bank exceptions
- Synchronized account transactions and worker threads
- Executor thread pool, account store, generic repository
- File persistence, transaction log and report generation

## Notes
This is an educational lab project, not production banking software. It intentionally keeps the implementation understandable. The state persistence helper is included; automatic reload and full producer-consumer/deadlock demonstrations can be added as separate lab exercises.
