using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _875.KokoEatingBananasCSharp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var p = new int[]{332484035, 524908576, 855865114, 632922376, 222257295,
                690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 
                679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
            var h = 823855818;
            Console.WriteLine(MinEatingSpeed(p, h));
        }

        public static int MinEatingSpeed(int[] piles, int h)
        {
            var l = 1;
            var r = 0;
            foreach (var item in piles)
            {
                if (item > r)
                {
                    r = item;
                }
            }

            while (l <= r)
            {
                var mid = l + ((r - l) / 2);
                var count = 0;
                var exceeded = false;

                for (int i = 0; i < piles.Length; i++)
                {
                    count += piles[i] % mid == 0 ? piles[i] / mid : piles[i] / mid + 1;

                    if (count > h)
                    {
                        exceeded = true;
                        break;
                    }
                }

                if (exceeded == true)
                {
                    l = mid + 1;
                }
                else
                {
                    r = mid - 1;
                }
            }

            return l;
        }
    }
}
