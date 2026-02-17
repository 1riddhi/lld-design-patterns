# 🏗️ LLD Design Patterns

> Clean, practical implementations of Gang of Four design patterns in Java — built for learning, interviews, and solid software design.

[![Java](https://img.shields.io/badge/Java-17+-orange?logo=openjdk)](https://openjdk.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

---

## 📖 Overview

This repository contains **concrete, runnable examples** of the classic design patterns — the essential toolkit for writing maintainable, extensible, and scalable code. Each pattern is implemented with clear structure, real-world analogies, and inline documentation to bridge theory and practice.

Whether you're preparing for system design interviews, leveling up your LLD skills, or revisiting fundamentals, these examples provide a solid reference.

---

## 🗂️ Project Structure

```
lld-design-patterns/
├── creational/          # Object creation patterns
├── structural/          # Object composition patterns
├── behavioral/          # Object interaction patterns
└── solid/              # SOLID principles reference
```

---

## 🧩 Patterns Catalog

### Creational Patterns
*How we create objects — decoupling creation logic from usage*

| Pattern | Description | Key Idea |
|---------|-------------|----------|
| [Factory](creational/FactoryPattern.java) | Hides object creation behind a factory method | Client uses `createVehicle("car")` instead of `new Car()` |
| [Abstract Factory](creational/AbstractFactoryPattern.java) | Creates families of related objects | Ensures compatible pairs (Car + CarEngine, Bike + BikeEngine) |
| [Builder](creational/BuilderPattern.java) | Constructs complex objects step by step | Fluent API for object construction with many optional params |
| [Prototype](creational/PrototypePattern.java) | Creates objects by cloning an existing instance | Copy instead of creating from scratch |
| [Singleton](creational/SingletonPattern.java) | Ensures a class has only one instance globally | Single shared instance with controlled access |

### Structural Patterns
*How we compose and organize objects — building flexible architectures*

| Pattern | Description | Key Idea |
|---------|-------------|----------|
| [Adapter](structural/AdapterPattern.java) | Bridges incompatible interfaces | Wraps `Adaptee.specificRequest()` as `Target.request()` |
| [Bridge](structural/BridgePattern.java) | Decouples abstraction from implementation | Separate what from how |
| [Composite](structural/Composite.java) | Treats individual and group objects uniformly | Tree structures with leaf and composite nodes |
| [Decorator](structural/DecoratorPattern.java) | Adds behavior dynamically without subclassing | Wraps objects to extend functionality |
| [Facade](structural/FacadePattern.java) | Simplifies complex subsystems | Single entry point for multiple classes |
| [Flyweight](structural/FlyWeightPattern.java) | Shares state to save memory | Reuses objects for repeated, lightweight data |
| [Proxy](structural/ProxyPattern.java) | Controls access to an object | Lazy loading, access control, logging |

### Behavioral Patterns
*How objects communicate and distribute responsibility*

| Pattern | Description | Key Idea |
|---------|-------------|----------|
| [Chain of Responsibility](behavioral/ChainOfResponsibilityPattern.java) | Passes request along a chain of handlers | Each handler can process or forward |
| [Command](behavioral/CommandPattern.java) | Encapsulates actions as objects | Undo, queues, logging, decoupling |
| [Interpreter](behavioral/InterpreterPattern.java) | Defines a grammar and interpreter for expressions | Used to evaluate expressions by representing each rule as an object. |
| [Iterator](behavioral/IteratorPattern.java) | Provides a way to access elements sequentially without exposing underlying structure | Traverse a collection via a standard iterator interface |
| [Mediator](behavioral/MediatorPattern.java) | Restricts direct communications between the objects and forces them to collaborate only via a mediator object | Objects communicate through a mediator instead of directly |
| [Memento](behavioral/MementoPattern.java) | Captures and restores an object's state without exposing its implementation details | Save and restore snapshots of an object's state |
| [Observer](behavioral/ObserverPattern.java) | One-to-many dependency for updates | Subject notifies subscribers on change |
| [State](behavioral/StatePattern.java) | Behavior changes with internal state | Object delegates to state-specific handlers |
| [Strategy](behavioral/StrategyPattern.java) | Interchangeable algorithms | Same task, different ways (e.g. Car vs Walking route) |
| [Template Method](behavioral/TemplateMethodPattern.java) | Skeleton algorithm with customizable steps | Subclasses fill in the blanks |
| [Visitor](behavioral/VisitorPattern.java) | Allows you to add new operations to a group of related classes without modifying their structures | Add new operations without changing related classes |

---

## 🎯 SOLID Principles

The foundation that makes design patterns effective:

| Principle | One-liner |
|-----------|-----------|
| **S**ingle Responsibility | One job per class |
| **O**pen/Closed | Extend, don’t modify |
| **L**iskov Substitution | Child behaves like parent |
| **I**nterface Segregation | Small, focused interfaces |
| **D**ependency Inversion | Depend on abstractions, not implementations |

See [solid/notes.txt](solid/notes.txt) for a concise reference.

---

## 🚀 Run the Examples

Each pattern is self-contained in a single `.java` file with a `main` method:

```bash
# Compile and run any pattern
javac creational/FactoryPattern.java
java -cp creational FactoryPattern

# Example: Strategy pattern
javac behavioral/StrategyPattern.java
java -cp behavioral StrategyPattern
```

Or use your IDE: open the file and run the `main` method.

---

## 📚 Quick Reference

| Use Case | Consider |
|----------|----------|
| Creating objects without `new` in client code | Factory, Abstract Factory |
| Integrating legacy/third-party code | Adapter |
| Adding behavior at runtime | Decorator, Strategy |
| One-to-many notifications | Observer |
| Different algorithms, same interface | Strategy |
| Replacing conditionals with objects | State |
| Decoupling sender and receiver | Command |

---

## 📁 File Layout

```
creational/
├── AbstractFactoryPattern.java
├── BuilderPattern.java
├── FactoryPattern.java
├── PrototypePattern.java
└── SingletonPattern.java

structural/
├── AdapterPattern.java
├── BridgePattern.java
├── Composite.java
├── DecoratorPattern.java
├── FacadePattern.java
├── FlyWeightPattern.java
└── ProxyPattern.java

behavioral/
├── ChainOfResponsibilityPattern.java
├── CommandPattern.java
├── InterpreterPattern.java
├── IteratorPattern.java
├── MediatorPattern.java
├── MementoPattern.java
├── ObserverPattern.java
├── StatePattern.java
├── StrategyPattern.java
├── TemplateMethodPattern.java
└── VisitorPattern.java

solid/
└── notes.txt
```

---

## 🤝 Contributing

Suggestions and pull requests are welcome. For new patterns or improvements:

1. Keep examples self-contained and runnable
2. Include brief comments on intent and structure
3. Use relatable, real-world analogies where possible

---

*Built for developers who believe good design is not accidental.*
