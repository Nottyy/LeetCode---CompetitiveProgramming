using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace _2.AddTwoNumbersRecursion
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var l1 = new ListNode(2);
            var l2 = new ListNode(4);
            var l3 = new ListNode(3);
            var l8 = new ListNode(3);
            var l9 = new ListNode(9);
            l1.next = l2;
            l2.next = l3;
            l3.next = l8;
            l8.next = l9;

            var l4 = new ListNode(5);
            var l5 = new ListNode(6);
            var l6 = new ListNode(4);
            l4.next = l5;
            l5.next = l6;


            var st = AddTwoNumbers(l1, l4);

            while (st != null && st.val != null)
            {
                Console.WriteLine(st.val + " ");
                st = st.next;
            }
        }

        public static ListNode AddTwoNumbers(ListNode l1, ListNode l2)
        {
            ListNode node = new ListNode((l1.val + l2.val) % 10);
            node.next = GetNextNode((l1.val + l2.val) / 10, l1.next, l2.next);

            return node;
        }

        public static ListNode GetNextNode(int mod, ListNode l1 = null, ListNode l2 = null)
        {
            if (l1 == null && l2 == null)
            {
                if (mod == 0)
                {
                    return null;
                }
                else
                {
                    return new ListNode(1);
                }
            }

            int sum;

            if (l1 == null && l2 != null)
            {
                sum = l2.val + mod;
            }
            else if (l2 == null && l1 != null)
            {
                sum = l1.val + mod;
            }
            else
            {
                sum = l1.val + l2.val + mod;
            }

            mod = sum / 10;
            var sumToAdd = sum % 10;

            ListNode node = new ListNode(sumToAdd);
            node.next = GetNextNode(mod, l1 == null ? null : l1.next, l2 == null ? null : l2.next);

            return node;
        }
    }
}
