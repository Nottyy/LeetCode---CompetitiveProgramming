using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _23.MergeKSortedLists
{
    internal class Program
    {
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

        static void Main(string[] args)
        {
            var node1 = new ListNode(1);
            var node11 = new ListNode(3);
            var node111 = new ListNode(4);
            var node1111 = new ListNode(7);
            node1.next = node11;
            node11.next = node111;
            node111.next = node1111;

            var node2 = new ListNode(2);
            var node22 = new ListNode(4);
            var node222 = new ListNode(5);
            var node2222 = new ListNode(10);
            node2.next = node22;
            node22.next = node222;
            node222.next = node2222;


            var res = MergeKLists(new ListNode[] { node1, node2 });
        }

        public static ListNode MergeKLists(ListNode[] lists)
        {
            var arr = new List<int>();

            foreach (var node in lists)
            {
                var current = node;
                while (current != null)
                {
                    arr.Add(current.val);
                    current = current.next;
                }
            }

            arr = arr.OrderBy(x => x).ToList();

            var result = new ListNode();
            var toReturn = result;

            for (int i = 0; i < arr.Count; i++)
            {
                result.next = new ListNode(arr[i]);
                result = result.next;
            }

            return toReturn.next;
        }
    }
}
