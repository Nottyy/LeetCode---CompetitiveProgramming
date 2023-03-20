using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;

namespace _17.LetterCombinationsOfAPhoneNumber
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var s = LetterCombinations("25");
            Console.WriteLine(string.Join(" ", s));
        }

        public static IList<string> LetterCombinations(string digits)
        {
            var result = new List<string>();

            if (string.IsNullOrEmpty(digits))
            {
                return result;
            }

            var dict = new Dictionary<char, string>
            {
                {'2', "abc"},
                {'3', "def"},
                {'4', "ghi"},
                {'5', "jkl"},
                {'6', "mno"},
                {'7', "pqrs"},
                {'8', "tuv"},
                {'9', "wxyz"}
            };

            BackTracking(digits, result, dict, 0, "");

            return result;
        }

        private static void BackTracking(string digits, List<string> result, Dictionary<char, string> dict, 
            int index, string curStr)
        {
            if (curStr.Length == digits.Length)
            {
                result.Add(curStr);
                return;
            }

            foreach (var c in dict[digits[index]])
            {
                BackTracking(digits, result, dict, index + 1, curStr + c);
            }
        }
    }
}
