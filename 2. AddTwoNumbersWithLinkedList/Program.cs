using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.AddTwoNumbersWithLinkedList
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var l1 = new ListNode(2);
            var l2 = new ListNode(4);
            var l3 = new ListNode(9);
            //var l8 = new ListNode(9);
            //var l9 = new ListNode(9);
            //var l10 = new ListNode(9);
            //var l11 = new ListNode(9);
            l1.next = l2;
            l2.next = l3;
            //l3.next = l8;
            //l8.next = l9;
            //l9.next = l10;
            //l10.next = l11;

            var l4 = new ListNode(5);
            var l5 = new ListNode(6);
            var l6 = new ListNode(4);
            var l7 = new ListNode(9);
            l4.next = l5;
            l5.next = l6;
            l6.next = l7;


            var st = AddTwoNumbers(l1, l4);

            while (st != null && st.val != null)
            {
                Console.WriteLine(st.val + " ");
                st = st.next;
            }
        }

        public static ListNode AddTwoNumbers(ListNode l1, ListNode l2)
        {
            var mod = 0;
            var node = new ListNode();
            var current = node;
            var first = true;

            while (l1 != null && l2 != null)
            {
                var sum = l1.val + l2.val + mod;
                mod = sum / 10;
                var sumToAdd = sum % 10;

                if (first)
                {
                    current.val = sumToAdd;
                    first = false;
                }
                else
                {
                    current.next = new ListNode(sumToAdd);
                    current = current.next;
                }

                l1 = l1.next;
                l2 = l2.next;

                if (l1 == null && l2 != null)
                {
                    while (l2 != null)
                    {
                        sum = l2.val + mod;
                        mod = sum / 10;
                        sumToAdd = sum % 10;

                        current.next = new ListNode(sumToAdd);
                        current = current.next;
                        l2 = l2.next;
                    }
                }

                if (l2 == null && l1 != null)
                {
                    while (l1 != null)
                    {
                        sum = l1.val  + mod;
                        mod = sum / 10;
                        sumToAdd = sum % 10;

                        current.next = new ListNode(sumToAdd);
                        current = current.next;
                        l1 = l1.next;
                    }
                }
            }

            if (mod != 0)
            {
                current.next = new ListNode(1);
            }

            return node;
        }
    }
}
