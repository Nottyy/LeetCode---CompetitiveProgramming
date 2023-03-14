using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.RegularExpressionMatching
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(IsMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*b"));
        }
        public static bool IsMatch(string s, string p)
        {
            return DFS(s, p, 0, 0);
        }

        private static bool DFS(string s, string p, int i, int j)
        {
            if (i >= s.Length && j >= p.Length)
            {
                return true;
            }

            if (j >= p.Length)
            {
                return false;
            }

            bool match = i < s.Length && (s[i] == p[j] || p[j] == '.');

            if (j + 1 < p.Length && p[j + 1] == '*')
            {
                var resultWithSkippingTheStar = DFS(s, p, i, j + 2);
                var resultWithUsingTheStar = match && DFS(s, p, i + 1, j);
                return resultWithSkippingTheStar || resultWithUsingTheStar;
            }

            if (match)
            {
                return DFS(s, p, i + 1, j + 1);
            }

            return false;
        }
    }
}
