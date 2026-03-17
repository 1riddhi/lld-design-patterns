// Command pattern encapsulates a request(command) as an object
//  so that it can be executed, queued, logged, or undone later.


//invoker -> command -> receiver
//invokder has command
//command has receiver

//Command pattern converts operations into objects
//so that operations can be stored, undone, or executed later.

import java.util.Stack;

// 1️⃣ Command Interface
interface Command {
    void execute();
    void undo();
}

// 2️⃣ Receiver
class Document {
    private StringBuilder text = new StringBuilder();

    public void write(String str) {
        text.append(str);
    }

    public void erase(int length) {
        text.delete(text.length() - length, text.length());
    }

    public String getText() {
        return text.toString();
    }
}

// 3️⃣ Concrete Command
class WriteCommand implements Command {

    private Document document;
    private String text;

    public WriteCommand(Document document, String text) {
        this.document = document;
        this.text = text;
    }

    @Override
    public void execute() {
        document.write(text);
    }

    @Override
    public void undo() {
        document.erase(text.length());
    }
}

// 4️⃣ Invoker
class Editor {

    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear(); // Clear redo history after new action
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}

// 5️⃣ Client
public class CommandPattern {

    public static void main(String[] args) {

        Document document = new Document();
        Editor editor = new Editor();

        editor.executeCommand(new WriteCommand(document, "Hello "));
        editor.executeCommand(new WriteCommand(document, "World"));

        System.out.println(document.getText()); // Hello World

        editor.undo();
        System.out.println(document.getText()); // Hello 

        editor.redo();
        System.out.println(document.getText()); // Hello World
    }
}
