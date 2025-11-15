# academic-java-oop-project
## CCTB Final OOP Project (Order Kiosk CLI)

This is the final project for the Object-Oriented Programming (OOP) course. It is a command-line interface (CLI) application for a simple order kiosk. The project demonstrates core OOP principles, including:

* **Domain Modeling:** Using classes like `MenuItem` and `Cart` to model a real-world problem.
* **Separation of Concerns:** Separating data (models), business rules (services), and I/O (the `cli` package).
* **Abstraction:** Using `interfaces` (`TaxCalculator`, `CatalogRepository`) to decouple the application from specific implementations.
* **Unit Testing:** Using JUnit to verify the logic of the models and services.

## Key Classes and Design

Here is a summary of the main classes and their responsibilities, as requested.

### 1. `model` Package (The Core Domain)

This package contains the POJOs (Plain Old Java Objects) that represent the project's core data and business logic.

* `MenuItem.java`: An **immutable** class that holds the data for a menu item (name and price). It uses `BigDecimal` for currency to avoid floating-point errors.
* `CartItem.java`: A simple class that links a `MenuItem` to a `quantity`.
* `Cart.java`: The main "engine" of the application. It is responsible for:
    * Adding new items.
    * Merging quantities if the *same* item is added twice.
    * Removing items.
    * Calculating the `subtotal()` by summing all `CartItem` totals.

### 2. `interfaces` and `repo` Packages (Abstraction)

To keep the application flexible, I used interfaces to separate *what* the application does from *how* it does it.

* `TaxCalculator.java` (Interface): Defines a simple contract for any class that can calculate tax based on an amount.
* `FlatRateTaxCalculator.java` (Implementation): A specific implementation that calculates a single flat-rate tax (e.g., 6%).
* `CatalogRepository.java` (Interface): Defines a contract for any class that can provide a list of menu items.
* `InMemoryCatalogRepository.java` (Implementation): A simple "fake" database. It provides a hard-coded list of `MenuItem`s so the application can run without a real database.

### 3. `ReceiptService.java` (Separating Logic from I/O)

This class is a key part of the "Separation of Concerns" principle. Its only job is to:
1.  Take a `Cart` and a `TaxCalculator`.
2.  Calculate the subtotal, tax, and grand total.
3.  Return a `List<String>` containing the fully formatted, human-readable receipt.

It does **not** do any `System.out.println`. This keeps the calculation logic separate from the printing, making it easy to test.

### 4. `cli.Main.java` (The "Edge" of the Application)

This is the only class that handles user I/O (Input/Output). It is responsible for:
* Starting the application and printing `help`.
* Using `Scanner` to read user commands.
* Parsing the commands (e.g., `add Coffee 2`).
* Calling the correct methods on the `Cart` or `repo`.
* Printing the results (like the menu or the final receipt) to the console.

## How to Build and Run

This project is built using Apache Maven.

### 1. Run Unit Tests

To compile the project and run all JUnit tests:
```bash
mvn test
```

## Screenshots

Here is the flow of an order:

**1. Viewing the Menu**
<img width="2559" height="1531" alt="image" src="https://github.com/user-attachments/assets/8c18d1bb-c4f9-42d0-8dd8-396f8ecb58e9" />


**2. Adding Items to the Cart**
<img width="2559" height="1529" alt="image" src="https://github.com/user-attachments/assets/74cd84a3-60b7-49f4-ac0f-4b312c32cbfe" />


**3. Final Receipt**
<img width="2559" height="1529" alt="image" src="https://github.com/user-attachments/assets/a3da62d6-540e-46ac-ba24-2c49f7ac2b60" />
