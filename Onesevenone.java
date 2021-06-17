import java.util.*;

// not 171 now, changed to another question
class Onesevenone{
   public static void main(String[] args){
      Stack<Integer> stack = new Stack<>();
        ListNode newNode = new ListNode();
        ListNode newCurr = newNode;
        
        ListNode curr = head;
        while(curr != null){
            stack.push(curr.val);
            newCurr.val = curr.val;
            curr=curr.next;
            
            ListNode newNode1 = new ListNode();
            newCurr.next = newNode1;
            newCurr = newCurr.next;            
        }
        
        
        while(newNode!=null){
         System.out.print(newNode.val + " ");
        }
     
    }
   
}






// 
// class Solution {
//     public Node copyRandomList(Node head) {              
//         if (head == null) return null;
//   
//           Map<Node, Node> map = new HashMap<Node, Node>();
// 
//           // loop 1. copy all the nodes
//           Node node = head;
//           while (node != null) {
//             map.put(node, new Node(node.val));
//             node = node.next;
//           }
// 
//           // loop 2. assign next and random pointers
//           node = head;
//           while (node != null) {
//             map.get(node).next = map.get(node.next);
//             map.get(node).random = map.get(node.random);
//             node = node.next;
//           }
// 
//           return map.get(head);
//     }
// }
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// class Solution {
//     public List<Integer> findAnagrams(String s, String t) {
//         // SEE DISCUSS
//         // ALSO: https://www.geeksforgeeks.org/window-sliding-technique//
//         
//         List<Integer> result = new LinkedList<>();
//         if(t.length()> s.length()) return result;
//         
//         Map<Character, Integer> map = new HashMap<>();
//         for(char c : t.toCharArray()){
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         int counter = map.size();
//         
//         int begin = 0, end = 0;          
//         while(end < s.length()){
//             char c = s.charAt(end);
//             if( map.containsKey(c) ){
//                 map.put(c, map.get(c)-1);
//                 if(map.get(c) == 0) counter--;
//             }
//             end++;
//             
//             while(counter == 0){
//                 char tempc = s.charAt(begin);
//                 if(map.containsKey(tempc)){                    
//                     if(map.get(tempc) == 0) counter++;  //need to increase counter when it first adds back to the map.
//                     map.put(tempc, map.get(tempc) + 1);
//                 }
//                 if(end-begin == t.length()){
//                     result.add(begin);
//                 }
//                 begin++;
//             }
//             
//         }
//         return result;
//     }
// }





// template: changed a little bit in below:
// if(map.get(tempc) == 0) counter++;
// map.put(tempc, map.get(tempc) + 1);

// public class Solution {
//     public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
//         //init a collection or int value to save the result according the question.
//         List<Integer> result = new LinkedList<>();
//         if(t.length()> s.length()) return result;
        
//         //create a hashmap to save the Characters of the target substring.
//         //(K, V) = (Character, Frequence of the Characters)
//         Map<Character, Integer> map = new HashMap<>();
//         for(char c : t.toCharArray()){
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         //maintain a counter to check whether match the target string.
//         int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.
        
//         //Two Pointers: begin - left pointer of the window; end - right pointer of the window
//         int begin = 0, end = 0;
        
//         //the length of the substring which match the target string.
//         int len = Integer.MAX_VALUE; 
        
//         //loop at the begining of the source string
//         while(end < s.length()){
            
//             char c = s.charAt(end);//get a character
            
//             if( map.containsKey(c) ){
//                 map.put(c, map.get(c)-1);// plus or minus one
//                 if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
//             }
//             end++;
            
//             //increase begin pointer to make it invalid/valid again
//             while(counter == 0 /* counter condition. different question may have different condition */){
                
//                 char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
//                 if(map.containsKey(tempc)){
//                     if(map.get(tempc) == 0) counter++;  //need to increase counter when it first adds back to the map.
//                     map.put(tempc, map.get(tempc) + 1);//plus or minus one
//                 }
                
//                 /* save / update(min/max) the result if find a target*/
//                 // result collections or result int value
                
//                 begin++;
//             }
//         }
//         return result;
//     }
// }