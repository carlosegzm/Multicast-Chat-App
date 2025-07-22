# Java UDP Multicast Chat

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

A group messaging application using **UDP Multicast** in Java. Enables real-time text communication between multiple clients in a local network group.

## 📌 Features

- Join/leave multicast groups  
- JSON-formatted messages  
- Separate thread for receiving messages  
- Real-time text chat in Swing interface

## 🧰 Technologies

- Java 11+  
- Java Swing  
- MulticastSocket (UDP)  
- Gson

## 🛠 Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/carlosegzm/Chat-Multicast
   cd Chat-Multicast
   ```

2. Run the chat GUI:
   ```
   src/view/Tela.java
   ```

## 📁 Structure

```
src/
├── view/         # GUI components
├── controller/   # Thread logic and events
├── model/        # Message models
├── util/         # Multicast socket helpers
```

## 📖 Educational Use

Created for practicing Java network programming using multicast sockets and building responsive UI with multithreading.

## 📝 License

MIT License
