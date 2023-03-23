using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _22.GenerateParentheses
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var res = GenerateParenthesis(3);
            Console.WriteLine(String.Join(" ", res));
        }

        public static IList<string> GenerateParenthesis(int n)
        {
            var result = new List<string>();

            BackTracking(result, 0, 0, n, "");

            return result;
        }

        public static void BackTracking(IList<string> result, int numLeft, int numRight, int target, string curResult)
        {
            if (numLeft > target || numRight > target || numRight > numLeft)
            {
                return;
            }

            if (numLeft == target && numRight == target)
            {
                result.Add(curResult);
                return;
            }

            // append '('
            BackTracking(result, numLeft + 1, numRight, target, curResult + '(');

            // append ')'
            BackTracking(result, numLeft, numRight + 1, target, curResult + ')');
        }
    }
}
