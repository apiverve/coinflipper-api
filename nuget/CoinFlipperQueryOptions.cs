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
        /// Number of coins to flip
        /// </summary>
        [JsonProperty("flips")]
        public int? Flips { get; set; }
    }
}
