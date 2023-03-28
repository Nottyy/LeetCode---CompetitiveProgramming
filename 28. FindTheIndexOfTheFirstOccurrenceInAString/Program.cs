using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _28.FindTheIndexOfTheFirstOccurrenceInAString
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(StrStr("popsod", "pss"));

        }

        public static int StrStr(string haystack, string needle)
        {
            var st = haystack.IndexOf(needle);
            return st;
        }
    }
}
