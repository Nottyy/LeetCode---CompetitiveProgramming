using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.AddTwoNumbers
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
            int firstNumber = ReadNumberFromLinkedList(l1);
            int secondNumber = ReadNumberFromLinkedList(l2);

            ListNode result = ConvertNumberToListNode(firstNumber + secondNumber);

            return result;
        }

        private static ListNode ConvertNumberToListNode(int num)
        {
            var length = num.ToString().Length;
            var node = new ListNode(num % 10);
            var current = node;
            num /= 10;

            for (int i = 1; i < length; i++)
            {
                current.next = new ListNode(num % 10);
                num /= 10;
                current = current.next;
            }

            return node;
        }

        private static int ReadNumberFromLinkedList(ListNode l1)
        {
            var array = new List<long>();
            array.Add(l1.val);
            l1 = l1.next;

            while (l1 != null)
            {
                array.Add(l1.val);

                l1 = l1.next;
            }

            array.Reverse();

            return int.Parse(string.Concat(array));
        }
    }
}
