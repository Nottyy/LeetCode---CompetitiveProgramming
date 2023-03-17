using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _14.LongestCommonPrefix
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(LongestCommonPrefix(new string[] { "flowersss", "flow", "floght" }));
        }

        public static string LongestCommonPrefix(string[] strs)
        {
            var sorted = strs.OrderBy(x => x.Length).ToArray();
            var pattern = sorted[0];
            var length = pattern.Length;

            for (int i = 0; i < length; i++)
            {
                var check = true;

                foreach (var item in sorted)
                {
                    var comparedTo = item.Substring(0, length - i);
                    if (pattern != comparedTo)
                    {
                        check = false;
                        break;
                    }
                }

                if (check)
                {
                    return pattern;
                }
                else
                {
                    pattern = pattern.Substring(0, length - i - 1);
                }
            }
            return pattern;
        }
    }
}
