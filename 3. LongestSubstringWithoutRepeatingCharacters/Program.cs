using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml.Schema;

namespace _3.LongestSubstringWithoutRepeatingCharacters
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(LengthOfLongestSubstring("aabaab!bb"));
            // "abaa"
            // dvgdabsr
        }

        public static int LengthOfLongestSubstring(string s)
        {
            if (s.Length == 1)
            {
                return 1;
            }
            var hash = new HashSet<char>();
            var indeces = new Dictionary<char, int>();
            var max = 0;
            var current = 0;
            var startIndex = 0;

            //   aabaab!bb
            //   abcabcbb

            for (int i = 0; i < s.Length; i++)
            {
                if (hash.Contains(s[i]))
                {
                    if (current > max)
                    {
                        max = current;
                    }
                    current = i - 1 - indeces[s[i]];

                    hash.Clear();

                    for (int j = indeces[s[i]]; j < i; j++)
                    {
                        hash.Add(s[j]);
                    }
                }

                hash.Add(s[i]);
                indeces[s[i]] = i;
                current++;
            }

            return current > max ? current : max;
        }
    }
}
