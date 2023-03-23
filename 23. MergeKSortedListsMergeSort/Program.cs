using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _23.MergeKSortedListsMergeSort
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

    internal class Program
    {
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

            var node3 = new ListNode(12);
            var node33 = new ListNode(44);
            var node333 = new ListNode(225);
            var node3333 = new ListNode(226);
            node3.next = node33;
            node33.next = node333;
            node333.next = node3333;

            var list = new ListNode[] { node1, node2, node3 };

            var res = MergeKLists(list);
        }

        public static ListNode MergeKLists(ListNode[] lists)
        {
            if (lists.Length == 0)
            {
                return null;
            }

            if (lists.Length == 1)
            {
                return lists[0];
            }

            ListNode[] result = null;

            while (lists.Length > 1)
            {
                result = new ListNode[(lists.Length + 1) / 2];
                for (int i = 0; i < lists.Length; i += 2)
                {
                    var l1 = lists[i];
                    var l2 = i + 1 < lists.Length ? lists[i + 1] : null;

                    var res = MergeSort(l1, l2);
                    result[i / 2] = res;


                }

                lists = result;

            }

            return result[0];
        }

        private static ListNode MergeSort(ListNode list1, ListNode list2)
        {
            var result = new ListNode();
            var toReturn = result;

            if (list1 == null && list2 == null)
            {
                return null;
            }

            if (list1 == null && list2 != null)
            {
                return list2;
            }

            if (list1 != null && list2 == null)
            {
                return list1;
            }

            while (list1 != null || list2 != null)
            {
                var val1 = list1.val;
                var val2 = list2.val;

                if (val1 > val2)
                {
                    result.next = new ListNode(val2);
                    result = result.next;
                    list2 = list2.next;

                    if (list2 == null)
                    {
                        while (list1 != null)
                        {
                            result.next = new ListNode(list1.val);
                            result = result.next;
                            list1 = list1.next;
                        }
                    }
                }
                else if (val1 <= val2)
                {
                    result.next = new ListNode(val1);
                    result = result.next;
                    list1 = list1.next;

                    if (list1 == null)
                    {
                        while (list2 != null)
                        {
                            result.next = new ListNode(list2.val);
                            result = result.next;
                            list2 = list2.next;
                        }
                    }
                }
            }

            return toReturn.next;
        }
    }
}
