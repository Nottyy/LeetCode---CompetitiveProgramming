using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _19.RemoveNthNodeFromEndOfList
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var node1 = new ListNode(1);
            //var node2 = new ListNode(2);
            //var node3 = new ListNode(3);
            //var node4 = new ListNode(4);
            //var node5 = new ListNode(5);

            //node1.next = node2;
            //node2.next = node3;
            //node3.next = node4;
            //node4.next = node5;

            var head = RemoveNthFromEnd(node1, 1);

            while (head != null)
            {
                Console.Write(head.val + " ");
                head = head.next;
            }
        }
        public class ListNode
        {
            public int val;
            public ListNode next;
            public ListNode(int val = 0, ListNode next = null)
            {
                this.val = val;
                this.next = next;
            }
        }

        public static ListNode RemoveNthFromEnd(ListNode head, int n)
        {
            var sz = 0;
            var headCopy = head;

            while (headCopy != null)
            {
                headCopy = headCopy.next;
                sz++;
            }

            if (sz == 1 && n == 1)
            {
                return null;
            }

            if (n == sz)
            {
                return head.next;
            }

            headCopy = head;
            for (int i = 0; i < sz - n - 1; i++)
            {
                headCopy = headCopy.next;
            }
            headCopy.next = headCopy.next.next;

            return head;
        }
    }
}
