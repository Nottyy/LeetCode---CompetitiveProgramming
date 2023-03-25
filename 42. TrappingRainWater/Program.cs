using System;
using System.Collections.Generic;
using System.Diagnostics.Eventing.Reader;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _42.TrappingRainWater
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // 4, 6, 5, 3, 2, 1, 2, 0, 0, 4, 6
            // 5, 3, 1, 2, 0, 0, 4, 0, 0, 6
            var arr = new int[] { 4, 2, 0, 3, 2, 5 };
            Console.WriteLine(Trap(arr));
        }

        public static int Trap(int[] height)
        {
            if (height.Length == 1 || height.Length == 2)
            {
                return 0;
            }

            var result = 0;
            var max = height[0];
            var prev = height[0];
            var stack = new Stack<Tuple<int, int>>();
            var index = 1;

            while (index < height.Length)
            {
                var cur = height[index];

                if (cur > prev)
                {
                    if (stack.Count > 0)
                    {
                        while (stack.Count > 0 && stack.Peek().Item1 <= cur)
                        {
                            var val = stack.Pop();
                            result += (val.Item1 - prev) * (index - val.Item2 - 1);
                            prev = val.Item1;
                        }

                        if (stack.Count > 0 && stack.Peek().Item1 > cur)
                        {
                            result += (cur - prev) * (index - stack.Peek().Item2 - 1);
                        }
                    }
                    prev = cur;
                }
                else if (cur < prev)
                {
                    stack.Push(new Tuple<int, int>(prev, index - 1));
                    prev = cur;
                }

                index++;
            }

            return result;
        }
    }
}
