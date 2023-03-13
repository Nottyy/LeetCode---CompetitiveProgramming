using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Net.Mime.MediaTypeNames;

namespace _5.LongestPalindromicSubstring
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Console.WriteLine("asd".Reverse().ToString());
            Console.WriteLine(LongestPalindrome("cbbd"));
        }

        public static string LongestPalindrome(string s)
        {
            // babad
            // cbbd
            if (s.Length == 1)
            {
                return s;
            }

            string result = "";

            for (int i = 0; i < s.Length; i++)
            {
                var counter = s.Length - i;

                while (counter > result.Length && counter > 1)
                {
                    var substr = s.Substring(i, counter);
                    string substrLeft = substr.Substring(0, substr.Length / 2);
                    string substrRight;

                    if (substr.Length % 2 != 0)
                    {
                        substrRight = substr.Substring(substr.Length / 2 + 1);
                    }
                    else
                    {
                        substrRight = substr.Substring(substr.Length / 2);
                    }

                    char[] array = substrRight.ToCharArray();
                    Array.Reverse(array);
                    var reversedStr = new String(array);

                    if (substrLeft.Equals(reversedStr))
                    {
                        result = substr;
                    }

                    counter--;
                }
            }

            return result == "" ? s[0].ToString() : result;
        }
    }
}
