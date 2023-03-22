using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20.ValidParentheses
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(IsValid("(("));
        }
        public static bool IsValid(string s)
        {
            if (s.Length % 2 != 0)
            {
                return false;
            }
            var stack = new Stack<char>();

            foreach (var c in s)
            {
                if (c == '(' || c == '[' || c == '{')
                {
                    stack.Push(c);
                }
                else
                {
                    if (stack.Count == 0)
                    {
                        return false;
                    }

                    var popChar = stack.Pop();
                    if (popChar == '(')
                    {
                        if (c != ')')
                        {
                            return false;
                        }
                    }
                    else if (popChar == '{')
                    {
                        if (c != '}')
                        {
                            return false;
                        }
                    }
                    else if (popChar == '[')
                    {
                        if (c != ']')
                        {
                            return false;
                        }
                    }
                }
            }

            return stack.Count == 0 ? true : false;
        }
    }
}
