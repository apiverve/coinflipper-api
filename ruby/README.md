# Coin Flipper API - Ruby Gem

Coin Flipper simulates random coin flips and records heads or tails outcomes with flip counts. Paid plans can simulate multiple flips per request and calculate percentages, streak lengths, and fairness indicators.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_coinflipper'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_coinflipper
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_coinflipper'

# Initialize the client
client = APIVerve::Coinflipper::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ flips: 1 })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ flips: 1 })
  puts response["data"]
rescue APIVerve::Coinflipper::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Coinflipper::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Coinflipper::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "total_flips": 10,
    "flips": [
      "Tails",
      "Heads",
      "Heads",
      "Tails",
      "Tails",
      "Heads",
      "Tails",
      "Tails",
      "Tails",
      "Tails"
    ],
    "heads_count": 3,
    "tails_count": 7,
    "heads_percentage": 30,
    "tails_percentage": 70,
    "longest_streak": {
      "length": 4,
      "type": "Tails"
    },
    "first_flip": "Tails",
    "last_flip": "Tails",
    "is_fair": false
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/coinflipper?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/coinflipper?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/coinflipper?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
