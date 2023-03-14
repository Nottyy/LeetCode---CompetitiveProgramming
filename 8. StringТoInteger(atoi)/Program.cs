using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _8.StringТoInteger_atoi_
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(MyAtoi(" .42"));
        }

        public static int MyAtoi(string s)
        {
            var strings = s.Trim().Split(' ').ToArray();
            var negative = false;
            int start = -1;
            int end = -1;

            var x = strings[0];

            for (int i = 0; i < x.Length; i++)
            {
                if (x[i] == '+' && i == 0)
                {
                    continue;
                }

                if (x[i] == '-' && i == 0)
                {
                    negative = true;
                    continue;
                }

                if (x[i] == '.')
                {
                    return 0;
                }

                if (!char.IsDigit(x[i]))
                {
                    return 0;
                }

                if (Char.IsDigit(x[i]))
                {
                    start = i;
                    var dotCounter = 0;

                    while (i < x.Length && (Char.IsDigit(x[i]) || x[i] == '.') && dotCounter <= 1)
                    {
                        if (x[i] == '.')
                        {
                            dotCounter++;
                        }
                        end = i;
                        i++;
                    }

                    if (start != - 1 && end == -1)
                    {
                        end = start;
                    }

                    var res = double.Parse(x.Substring(start, end - start + 1));
                    res = negative == true ? (res * -1) : res;

                    if (res >= int.MaxValue)
                    {
                        res = int.MaxValue;
                    }
                    else if (res < int.MinValue)
                    {
                        res = int.MinValue;
                    }

                    return (int)res;
                }
            }

            return 0;
        }
    }
}
