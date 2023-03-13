using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _7.ReverseInteger
{
    internal class Program
    {
        static void Main(string[] args)
        {
            
            Console.WriteLine(Reverse(1534236469));
        }

        public static int Reverse(int x)
        {
            if (x >= int.MaxValue || x <= int.MinValue)
            {
                return 0;
            }

            long res = x;
            bool isNegative = false;
            if (x < 0)
            {
                isNegative = true;
                x = Math.Abs(x);
            }
            long result = 0;

            while (x > 0)
            {
                result = result * 10 + x % 10;
                x /= 10;
            }

            if (result > int.MaxValue || result < int.MinValue)
            {
                return 0;
            }

            return isNegative ? (int)result * -1 : (int)result;
        }
    }
}
