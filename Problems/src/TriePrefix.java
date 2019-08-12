public class TriePrefix {
   class TrieNode {
      boolean isWord;
      TrieNode[] children = new TrieNode[26];
   }
   /** Initialize your data structure here. */

   TrieNode root;
   public TriePrefix() {
      root = new TrieNode();
   }

   /** Inserts a word into the trie. */
   public void insert(String word) {
      TrieNode node = root;
      for(char c : word.toCharArray()) {
         if(node.children[c - 'a'] == null)
            node.children[c - 'a'] = new TrieNode();
         node = node.children[c - 'a'];
      }
      node.isWord = true;
   }

   /** Returns if the word is in the trie. */
   public boolean search(String word) {
      TrieNode node = root;
      for(char c : word.toCharArray()) {
         if (node.children[c - 'a'] == null)
            return false;
         node = node.children[c - 'a'];
      }
      return node.isWord;
   }

   public boolean delete(String word) {
      TrieNode node = find(word);
      if(node == null)
         return false;
      boolean hasOtherChild = false;
      for(TrieNode child : node.children) {
         if (child != null)
            hasOtherChild = true;
      }
      if(!hasOtherChild)
         node = null;
      else {
         node.isWord = false;
      }
      return true;
   }

   public TrieNode find(String word) {
      TrieNode node = root;
      for(char c : word.toCharArray()) {
         if (node.children[c - 'a'] == null)
            return null;
         node = node.children[c - 'a'];
      }
      return node;
   }

   /** Returns if there is any word in the trie that starts with the given prefix. */
   public boolean startsWith(String prefix) {
      TrieNode node = root;
      for(char c : prefix.toCharArray()) {
         if (node.children[c - 'a'] == null)
            return false;
         node = node.children[c - 'a'];
      }
      return true;
   }

   public static void main(String[] args) {
      TriePrefix trie = new TriePrefix();
      trie.insert("apple");
      System.out.println(trie.search("apple"));   // returns true
      System.out.println(trie.search("app"));     // returns false
      System.out.println(trie.startsWith("app")); // returns true
      trie.insert("app");
      System.out.println(trie.search("app"));
      trie.delete("app");
      System.out.println(trie.search("app"));
      System.out.println(trie.search("apple"));   // returns true
   }
}
