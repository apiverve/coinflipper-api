# Coin Flipper API - Dart/Flutter Client

Coin Flipper simulates random coin flips and records heads or tails outcomes with flip counts. Paid plans can simulate multiple flips per request and calculate percentages, streak lengths, and fairness indicators.

[![pub package](https://img.shields.io/pub/v/apiverve_coinflipper.svg)](https://pub.dev/packages/apiverve_coinflipper)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Coin Flipper API](https://apiverve.com/marketplace/coinflipper?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_coinflipper: ^1.2.3
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_coinflipper/apiverve_coinflipper.dart';

void main() async {
  final client = CoinflipperClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'flips': 1
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Coin Flipper API](https://apiverve.com/marketplace/coinflipper?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/coinflipper](https://docs.apiverve.com/ref/coinflipper?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
