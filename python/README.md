Coin Flipper API
============

Coin Flipper is a tool for simulating coin flips. It can flip multiple coins at once and provides statistics including heads/tails counts, percentages, streaks, and fairness analysis for probability experiments and gaming.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [Coin Flipper API](https://apiverve.com/marketplace/api/coinflipper)

---

## Installation
	pip install apiverve-coinflipper

---

## Configuration

Before using the coinflipper API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Coin Flipper API documentation is found here: [https://docs.apiverve.com/api/coinflipper](https://docs.apiverve.com/api/coinflipper).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
# Import the client module
from apiverve_coinflipper.apiClient import CoinflipperAPIClient

# Initialize the client with your APIVerve API key
api = CoinflipperAPIClient("[YOUR_API_KEY]")
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
query = { "flips": 10 }
```

###### Simple Request

```
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```
{
  "status": "ok",
  "error": null,
  "data": {
    "total_flips": 10,
    "flips": [
      "Tails",
      "Tails",
      "Tails",
      "Tails",
      "Tails",
      "Heads",
      "Heads",
      "Heads",
      "Tails",
      "Tails"
    ],
    "heads_count": 3,
    "tails_count": 7,
    "heads_percentage": 30,
    "tails_percentage": 70,
    "longest_streak": {
      "length": 5,
      "type": "Tails"
    },
    "first_flip": "Tails",
    "last_flip": "Tails",
    "is_fair": false
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.