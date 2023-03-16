using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.ContainerWithMostWater
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var height = new int[] { 1, 8, 6, 2, 5, 4, 10, 3, 7 };
            Console.WriteLine(MaxArea(height));
        }

        public static int MaxArea(int[] height)
        {
            int l = 0;
            int r = height.Length - 1;
            int max = 0;

            while (l <= r)
            {
                var minNum = Math.Min(height[l], height[r]);
                var sum = minNum * (r - l);

                if (sum > max)
                {
                    max = sum;
                }

                if (height[l] < height[r])
                {
                    l++;
                }
                else
                {
                    r--;
                }
            }

            return max;
        }
    }
}
