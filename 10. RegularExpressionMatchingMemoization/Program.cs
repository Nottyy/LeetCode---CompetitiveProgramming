using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.RegularExpressionMatchingMemoization
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(IsMatch("aaaaaaaaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*"));
        }

        public static bool IsMatch(string s, string p)
        {
            var cache = new Dictionary<Cache, bool>();
            return DFS(s, p, 0, 0, cache);
        }

        private static bool DFS(string s, string p, int i, int j, Dictionary<Cache, bool> cache)
        {
            var cur = new Cache(i, j);
            if (cache.ContainsKey(cur))
            {
                return cache[cur];
            }

            if (i >= s.Length && j >= p.Length)
            {
                return true;
            }

            if (j >= p.Length)
            {
                return false;
            }

            bool match = i < s.Length && (s[i] == p[j] || p[j] == '.');

            if (j + 1 < p.Length && p[j + 1] == '*')
            {
                var checkWithRemovingTheStar = DFS(s, p, i, j + 2, cache);
                var checkWithKeepingTheStar = match && DFS(s, p, i + 1, j, cache);

                var result = checkWithRemovingTheStar || checkWithKeepingTheStar;
                var key = new Cache(i, j);

                cache[key] = result;

                return cache[key];
            }

            var curCache = new Cache(i, j);

            if (match)
            {
                cache[curCache] = DFS(s, p, i + 1, j + 1, cache);
                return cache[curCache];
            }

            cache[curCache] = false;
            return cache[curCache];
        }

        public class Cache
        {
            public Cache(int x, int y)
            {
                this.X = x;
                this.Y = y;
            }

            public int X { get; set; }
            public int Y { get; set; }

            public override bool Equals(object obj)
            {
                var other = obj as Cache;
                return this.X == other.X && this.Y == other.Y;
            }

            public override int GetHashCode()
            {
                return this.X.GetHashCode() + this.Y.GetHashCode();
            }
        }
    }
}
