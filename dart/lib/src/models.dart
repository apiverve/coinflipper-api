/// Response models for the Coin Flipper API.

/// API Response wrapper.
class CoinflipperResponse {
  final String status;
  final dynamic error;
  final CoinflipperData? data;

  CoinflipperResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory CoinflipperResponse.fromJson(Map<String, dynamic> json) => CoinflipperResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? CoinflipperData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Coin Flipper API.

class CoinflipperData {
  int? totalFlips;
  List<String>? flips;
  int? headsCount;
  int? tailsCount;
  int? headsPercentage;
  int? tailsPercentage;
  CoinflipperDataLongestStreak? longestStreak;
  String? firstFlip;
  String? lastFlip;
  bool? isFair;

  CoinflipperData({
    this.totalFlips,
    this.flips,
    this.headsCount,
    this.tailsCount,
    this.headsPercentage,
    this.tailsPercentage,
    this.longestStreak,
    this.firstFlip,
    this.lastFlip,
    this.isFair,
  });

  factory CoinflipperData.fromJson(Map<String, dynamic> json) => CoinflipperData(
      totalFlips: json['total_flips'],
      flips: (json['flips'] as List?)?.cast<String>(),
      headsCount: json['heads_count'],
      tailsCount: json['tails_count'],
      headsPercentage: json['heads_percentage'],
      tailsPercentage: json['tails_percentage'],
      longestStreak: json['longest_streak'] != null ? CoinflipperDataLongestStreak.fromJson(json['longest_streak']) : null,
      firstFlip: json['first_flip'],
      lastFlip: json['last_flip'],
      isFair: json['is_fair'],
    );
}

class CoinflipperDataLongestStreak {
  int? length;
  String? type;

  CoinflipperDataLongestStreak({
    this.length,
    this.type,
  });

  factory CoinflipperDataLongestStreak.fromJson(Map<String, dynamic> json) => CoinflipperDataLongestStreak(
      length: json['length'],
      type: json['type'],
    );
}

class CoinflipperRequest {
  int? flips;

  CoinflipperRequest({
    this.flips,
  });

  Map<String, dynamic> toJson() => {
      if (flips != null) 'flips': flips,
    };
}
