using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _881.BoatsToSavePeople
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(NumRescueBoats(new int[] { 1, 2, 3, 4, 4 }, 5));
        }

        public static int NumRescueBoats(int[] people, int limit)
        {
            if (people.Length == 1)
            {
                return 1;
            }

            var result = 0;

            Array.Sort(people);

            var l = 0;
            var r = people.Length - 1;

            while (l < r)
            {
                if (people[l] + people[r] <= limit)
                {
                    l++;
                }

                r--;
                result++;
            }


            return l > r ? result : result + 1;
        }
    }
}
