# OS Process Scheduler Simulator

> **Java-based implementation of CPU scheduling and dynamic memory management.**

---

## 🖥️ Core Concepts
This project provides a simulation of an Operating System's CPU scheduling and memory management. It implements a **Round Robin** scheduling algorithm, handling process queues, dynamic memory allocation/deallocation, and performance metric calculations.

## 🏗️ Architecture & Features

### 1. Custom Data Structures
- **Custom Linked List (`ListaDinamica`):** Instead of using standard Java collections, the project implements a custom node-based linked list to manage process queues. This demonstrates a deep understanding of memory references, pointer manipulation, and custom data structure design.

### 2. CPU Scheduling & Memory Management
- **Round Robin Algorithm:** The scheduler uses a fixed quantum (configured via the `PlanificadorProcesos` class) to distribute CPU time among ready processes.
- **Dynamic Memory Allocation:** Each process requires a specific memory footprint (kB). The simulator enforces capacity limits (1024 kB) and dynamically loads/unloads processes based on memory availability.

### 3. Performance Metrics
The system tracks and computes critical OS metrics upon process completion:
- **Waiting Time:** Total time a process spends in the ready queue.
- **Turnaround Time:** Total time from arrival to completion.
- **Response Time:** Time from arrival until the process first enters the CPU.

---

## ⚙️ Technical Components

- **`main`:** The entry point where the process queue is initialized and the simulation environment is configured.
- **`PlanificadorProcesos`:** The execution engine. Handles the logic for the CPU quantum, state transitions, and memory management.
- **`Proceso`:** Encapsulates process metadata (Arrival time, priority, burst time, memory requirements) and performs time-related calculations.
- **`ListaDinamica` & `Nodo`:** The underlying structures that maintain process order and manage memory state.

---

## 📊 Sample Output & Execution
The application logs every event in the simulation lifecycle:
- Process loading logs.
- CPU execution cycles (showing remaining burst time).
- Memory availability updates.
- Performance statistics generated for each process upon termination.

---

## 🪪 About the Project

This simulator was developed as part of the **Operating Systems** coursework in the **Computer Engineering** program at **UNAM**. It serves as a proof of competence in **low-level logic implementation, concurrency simulation, and algorithmic optimization** in Java.

---
*Developed by Gerardo Gabriel Santana Amezcua.*
