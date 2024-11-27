package data;

 public class LinkedList{
            Node head;

            public void insertFront(String[] data){
                Node curr = new Node(data, head);
                head = curr;
            }

            public int size(){
                Node curr = head;

                int size = 0;

                while(curr != null){
                    size++;
                    curr = curr.getNext();                 
                }
                return size;
            }

            public String[] get(int index){
                if(index < 0 || index >= size()){
                    return null;
                }

                Node curr = head;

                for(int i = 0; i < index; i++){
                    curr = curr.getNext();
                }

                return curr.getData();
            }

        public boolean set(int index, String[] newData) {
            if (index < 0 || index >= size()) {
                return false;  // Index out of bounds
            }

            Node curr = head;

            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }

            curr.setData(newData);
            return true;  // Successfully updated data at index
        }

        public class Node{
            Node next;
            String[] data;

            public void setNext(Node next){
                this.next = next;
            }

            public void setData(String[] data){
                this.data = data;
            }

            public String[] getData(){
                return data;
            }

            public Node getNext(){
                return next;
            }

            public Node(String[] data, Node node){
                setData(data);
                setNext(node);
     }
}
}