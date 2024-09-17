import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    public void printWords() {
        printWordsHelper(root, "");
    }

    private void printWordsHelper(TrieNode current, String word) {
        if (current.isEndOfWord) {
            System.out.println(word);
        }
        for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
            printWordsHelper(entry.getValue(), word + entry.getKey());
        }
    }

    public boolean startWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return false;
            }
        }
        System.out.println(prefix);
        System.out.println(current);
        return true;
    }

    public String longestCommonPrefix() {
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;

        while (current != null && current.children.size() == 1 && !current.isEndOfWord) {
            Map.Entry<Character, TrieNode> entry = current.children.entrySet().iterator().next();
            prefix.append(entry.getKey());
            current = entry.getValue();
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("flower");
        trie.insert("flow");
        trie.insert("flight");

        trie.printWords();
        System.out.println(trie.startWith("fl"));
        System.out.println(trie.longestCommonPrefix());
    }
}
