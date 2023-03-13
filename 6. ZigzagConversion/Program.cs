using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _6.ZigzagConversion
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(Convert("A", 1));
        }

        public static string Convert(string s, int numRows)
        {
            var sb = new StringBuilder(); ;
            var rate = numRows == 1 ? 1 : (numRows - 1) * 2;

            for (int i = 0; i < numRows; i++)
            {
                for (int j = 0; j < s.Length; j += rate)
                {
                    
                    if (i == 0 || i == numRows - 1)
                    {
                        if (i + j < s.Length)
                        {
                            sb.Append(s[i + j]);
                        }
                    }
                    else
                    {
                        if (j + i < s.Length)
                        {
                            sb.Append(s[j + i]);
                        }

                        if (j + rate - i < s.Length)
                        {
                            sb.Append(s[j + rate - i]);
                        }
                    }
                }
            }

            return sb.ToString();
        }
    }
}
