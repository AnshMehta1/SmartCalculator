# SmartCalculator - Requirements & Design

## 1. 5 Whys Analysis

### Question: Why does a user need a calculator app?

**Why 1:**  
A user needs a calculator app to perform arithmetic calculations quickly.

**Why 2:**  
Why does the user need to perform calculations quickly?  
Because manually calculating numbers can take more time and may lead to mistakes.

**Why 3:**  
Why might manual calculations lead to mistakes?  
Because arithmetic operations involving multiple numbers can be difficult to calculate accurately.

**Why 4:**  
Why is accuracy important?  
Because users need reliable results when making decisions or completing mathematical tasks.

**Why 5:**  
Why should the calculator provide reliable results?  
Because a calculator should reduce manual effort while providing consistent and understandable results.

### Insight

The main purpose of SmartCalculator is to provide a simple, reliable, and
easy-to-use tool for performing common arithmetic calculations while handling
invalid input and calculation errors safely.

---

## 2. Functional Requirements

### FR1: Basic Arithmetic Operations

The calculator shall support the following arithmetic operations:

- Addition (`+`)
- Subtraction (`-`)
- Multiplication (`*`)
- Division (`/`)
- Modulus (`%`)

### FR2: User Input

The calculator shall allow the user to enter two numbers and an arithmetic
operator through the command-line interface.

### FR3: Continuous Operation

The calculator shall continue accepting calculations in a loop until the user
types `exit`.

### FR4: Division by Zero

The calculator shall detect division by zero and display a clear error
message instead of terminating unexpectedly.

### FR5: Result Display

The calculator shall display calculation results to two decimal places.

### FR6: Invalid Operators

The calculator shall detect unsupported operators and display a meaningful
error message.

### FR7: Invalid Numeric Input

The calculator shall handle invalid numeric input without crashing the
application.

---

## 3. Non-Functional Requirements

### NFR1: Performance

Each calculation should be processed and displayed within one second under
normal usage.

### NFR2: Usability

Error messages should be clear, concise, and understandable to a user
without requiring knowledge of Java or programming.

### NFR3: Maintainability

The application should use a clear object-oriented structure so that new
operations and features can be added without rewriting the entire application.

---

## 4. Out of Scope

The following features will not be built as part of the core CLI calculator:

- No graphical desktop interface.
- No web server or backend.
- No database.
- No user accounts or authentication.
- No network communication.
- No external APIs.
- No advanced scientific calculator functionality.
- No JavaScript-based functionality in the web UI phase.

The final project will include a static HTML/CSS interface in the later phase,
but it will not require a backend or JavaScript.