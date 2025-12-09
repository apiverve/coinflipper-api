using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.CoinFlipper
{
    /// <summary>
    /// Query options for the Coin Flipper API
    /// </summary>
    public class CoinFlipperQueryOptions
    {
        /// <summary>
        /// Number of coins to flip (1-10000, default: 1)
        /// Example: 10
        /// </summary>
        [JsonProperty("flips")]
        public string Flips { get; set; }
    }
}
