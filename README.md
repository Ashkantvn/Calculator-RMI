# Calculator RMI

A simple Java RMI calculator. The client sends two numbers and an operator to a remote service, and the server performs the calculation.

## Features

- Addition (+)
- Subtraction (-)
- Multiplication (*)
- Division (/)
- Handles division by zero

## Project structure

```text
Calculator-RMI/
├── src/
│   ├── CalculatorService.java
│   ├── CalculatorServer.java
│   └── CalculatorClient.java
└── README.md
```

## Requirements

- Java JDK 8 or newer
- Two terminals (or two computers on the same network)

## Compile

From the project root:

```bash
javac -d out src/CalculatorService.java src/CalculatorServer.java src/CalculatorClient.java
```

## Run the server

In the first terminal:

```bash
java -cp out CalculatorServer
```

The server creates the RMI Registry on port 1099 and registers the service as `CalculatorService`.

## Run the client

In a second terminal on the same computer:

```bash
java -cp out CalculatorClient
```

For a server on another computer, pass its hostname or IP address:

```bash
java -cp out CalculatorClient 192.168.1.10
```

Make sure TCP port 1099 is reachable and that the server is running.

## Example output

Server terminal:

```text
Calculator RMI Server is running...
Service registered as: CalculatorService
```

Client terminal:

```text
Connected to Calculator RMI Server.
Enter first number: 20
Enter operator (+, -, *, /): *
Enter second number: 5
Result: 100.0
```

## Notes

- Start the server before starting the client.
- Division by zero is rejected with an error message.
- The example uses `localhost` when no server address is provided.
