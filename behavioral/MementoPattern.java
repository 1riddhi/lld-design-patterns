// Memento is a behavioral design pattern that lets you save and restore the previous state of an object 
// without revealing the details of its implementation.


// *Originator
// The object whose state we want to save

// *Memento
// Stores the snapshot of state

// * Caretaker
// Manages saved states (history stack)

// Memento
class EditorMemento {
    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Originator
class TextEditor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public EditorMemento save() {
        return new EditorMemento(content);
    }

    public void restore(EditorMemento memento) {
        content = memento.getContent();
    }
}

// Caretaker
class History {
    private java.util.Stack<EditorMemento> history = new java.util.Stack<>();

    public void save(EditorMemento memento) {
        history.push(memento);
    }

    public EditorMemento undo() {
        return history.pop();
    }
}

// Main
public class MementoPattern {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        History history = new History();

        editor.setContent("Version 1");
        history.save(editor.save());

        editor.setContent("Version 2");
        history.save(editor.save());

        editor.setContent("Version 3");

        System.out.println("Current: " + editor.getContent());

        editor.restore(history.undo());
        System.out.println("After Undo: " + editor.getContent());
    }
}
