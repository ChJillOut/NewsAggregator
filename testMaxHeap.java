import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class testMaxHeap {
    @Test
    public void testHeapSize() {
        Comparable[] h = new Comparable[10];
        int n = 3;
        int size = 10;
        h[0] = 1;
        h[1] = 2;
        h[2] = 3;
        MaxHeap heap = new MaxHeap(h, n, size);
        assertEquals(3, heap.heapSize());
    }

    @Test
    public void testIsLeaf() {
        Comparable[] h = new Comparable[10];
        int n = 3;
        int size = 10;
        h[0] = 1;
        h[1] = 2;
        h[2] = 3;
        MaxHeap heap = new MaxHeap(h, n, size);
        assertTrue(heap.isLeaf(2));
    }

    @Test
    public void testLeftChild() {
        Comparable[] h = new Comparable[10];
        int n = 3;
        int size = 10;
        h[0] = 1;
        h[1] = 2;
        h[2] = 3;
        MaxHeap heap = new MaxHeap(h, n, size);
        assertEquals(1, heap.leftChild(0));
    }

    @Test
    public void testRightChild() {
        Comparable[] h = new Comparable[10];
        int n = 3;
        int size = 10;
        h[0] = 1;
        h[1] = 2;
        h[2] = 3;
        MaxHeap heap = new MaxHeap(h, n, size);
        assertEquals(2, heap.rightChild(0));
    }

    @Test
    public void testParent() {
        Comparable[] h = new Comparable[10];
        int n = 3;
        int size = 10;
        h[0] = 1;
        h[1] = 2;
        h[2] = 3;
        MaxHeap heap = new MaxHeap(h, n, size);
        assertEquals(0, heap.parent(2));
    }

    @Test
    public void testInsert() {
        Comparable[] h = new Comparable[10];
        int n = 3;
        int size = 5;
        h[0] = 1;
        h[1] = 2;
        h[2] = 3;
        MaxHeap heap = new MaxHeap(h, n, size);
        heap.insert(5);
        heap.insert(6);
        heap.insert(8);
    }

    @Test
    public void testSwap() {
        Comparable[] h = new Comparable[10];
        int n = 3;
        int size = 5;
        h[0] = 1;
        h[1] = 2;
        h[2] = 3;
        MaxHeap heap = new MaxHeap(h, n, size);
        heap.swap(h, 0, 1);
    }

    @Test
    public void testSiftDown() {
        Comparable[] h = new Comparable[10];
        int n = 3;
        int size = 5;
        h[0] = 1;
        h[1] = 2;
        h[2] = 3;
        MaxHeap heap = new MaxHeap(h, n, size);
        heap.siftDown(10);
        heap.siftDown(0);
    }

    @Test
    public void testRemoveMax() {
        Comparable[] h = new Comparable[10];
        int n = 0;
        int size = 5;
        MaxHeap heap = new MaxHeap(h, n, size);
        assertEquals(-1, heap.removeMax());
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        assertEquals(3, heap.removeMax());
    }

    @Test
    public void testRemove() {
        Comparable[] h = new Comparable[10];
        int n = 3;
        int size = 5;
        h[0] = 1;
        h[1] = 2;
        h[2] = 3;
        MaxHeap heap = new MaxHeap(h, n, size);
        assertEquals(-1, heap.remove(6));
        assertEquals(1, heap.remove(2));
        assertEquals(3, heap.remove(0));
    }

    @Test
    public void testModifyandUpdate() {
        Comparable[] h = new Comparable[10];
        int n = 3;
        int size = 5;
        h[0] = 1;
        h[1] = 2;
        h[2] = 3;
        MaxHeap heap = new MaxHeap(h, n, size);
        heap.swap(h, 0, 1);
        heap.modify(10, 1);
        heap.modify(0, 2);
    }
}