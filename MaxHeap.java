import java.util.ArrayList;
import java.util.List;

// Max-heap implementation
class MaxHeap {
	private FeedMessage[] Heap; // Pointer to the heap array
	private int size; // Maximum size of the heap
	private int n; // Number of things now in heap
	String keyWord; // The keyword associate with this heap.

	/**
	 * Constructor for MaxHeap.
	 * @param capacity
	 * @param keyword
	 */
	MaxHeap(int capacity, String keyword) {
		Heap = new FeedMessage[capacity];
		size = capacity;
		n = 0;
		this.keyWord = keyword;
	}
	
	
	/**
	 * Convert the heap to an ArrayList 
	 * @return the converted list
	 */
	public ArrayList<FeedMessage> toList(){
		ArrayList<FeedMessage> res = new ArrayList<>();
		for(int i =0; i < n; i++){
			res.add(Heap[i]);
		}
		return res;
	}
	/**
	 * Return current size of the heap
	 * @return the size of the heap.
	 */
	int heapSize() {
		return n;
	}

	/**
	 * Return true if pos a leaf position, false otherwise
	 * @param pos the current position
	 * @return true if pos a leaf position, false otherwise
	 */
	boolean isLeaf(int pos) {
		return (pos >= n / 2) && (pos < n);
	}

	/**
	 * Return position for left child of pos
	 * @param pos the current position
	 * @return position for left child of pos
	 */
	int leftChild(int pos) {
		if (pos >= n / 2)
			return -1;
		return 2 * pos + 1;
	}

	/**
	 * Return position for right child of pos
	 * @param pos the current position
	 * @return position for right child of pos
	 */
	int rightChild(int pos) {
		if (pos >= (n - 1) / 2)
			return -1;
		return 2 * pos + 2;
	}

	/**
	 * Return position for parent
	 * @param pos the current position
	 * @return position for parent
	 */
	int parent(int pos) {
		if (pos <= 0)
			return -1;
		return (pos - 1) / 2;
	}

	/**
	 * Insert key into heap
	 * @param key the key to insert
	 */
	void insert(FeedMessage key) {
		if (n >= size) {
			System.out.println("Heap is full");
			return;
		}
		int curr = n;
		Heap[curr] = key;
		n++;
//		System.out.println();
		 // Start at end of heap
		// Now sift up until curr's parent's key > curr's key
		while ((curr != 0) && (Heap[curr].compareTo(Heap[parent(curr)], keyWord) > 0)) {
			swap(Heap, curr, parent(curr));
			curr = parent(curr);
		}
	}
	/**
	 * Perform the swapping of current and its parent
	 * @param h the heap array
	 * @param cur the current index
	 * @param par the parent's index
	 */
	public void swap(FeedMessage[] h, int cur, int par) {
		FeedMessage tmp = h[cur];
		h[cur] = h[par];
		h[par] = tmp;
	}
	/**
	 * Heapify contents of Heap
	 */
	void buildHeap() {
		for (int i = n / 2 - 1; i >= 0; i--)
			siftDown(i);
	}

	/**
	 * Put element in its correct place 
	 * @param pos the current position
	 */
	void siftDown(int pos) {
		if ((pos < 0) || (pos >= n))
			return; // Illegal position
		while (!isLeaf(pos)) {
			int j = leftChild(pos);
			if ((j < (n - 1)) && (Heap[j].compareTo(Heap[j + 1], keyWord) < 0))
				j++; // j is now index of child with greater value
			if (Heap[pos].compareTo(Heap[j], keyWord) >= 0)
				return;
			swap(Heap, pos, j);
			pos = j; // Move down
		}
	}

	/**
	 * Remove and return maximum value
	 * @return maximum value
	 */
	FeedMessage removeMax() {
		if (n == 0)
			return null; // Removing from empty heap
		swap(Heap, 0, --n); // Swap maximum with last value
		if (n != 0) // Not on last element
			siftDown(0); // Put new heap root val in correct place
		return Heap[n];
	}

	/**
	 * Remove and return element at specified position
	 * @param pos the current position
	 * @return element at the current position
	 */
	FeedMessage remove(int pos) {
		if ((pos < 0) || (pos >= n))
			return null; // Illegal heap position
		FeedMessage  res = Heap[pos];
		if (pos == (n - 1))
			n--; // Last element, no work to be done
		else {
			swap(Heap, pos, --n); // Swap with last value
			update(pos);
		}
		return res;
	}

	/**
	 * Modify the value at the given position
	 * @param pos the current position
	 * @param newVal the value to change into
	 */
	void modify(int pos, FeedMessage newVal) {
	    if ((pos < 0) || (pos >= n)) return; // Illegal heap position
	    Heap[pos] = newVal;
	    update(pos);
	  }

	//
	/**
	 *  The value at pos has been changed, restore the heap property
	 * @param pos the current position
	 */
	void update(int pos) {
	    // If it is a big value, push it up
	    while ((pos > 0) && (Heap[pos].compareTo(Heap[parent(pos)], keyWord) > 0)) {
	      swap(Heap, pos, parent(pos));
	      pos = parent(pos);
	    }
	    if (n != 0) siftDown(pos); // If it is little, push down
	  }
	}
