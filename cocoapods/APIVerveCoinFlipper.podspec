Pod::Spec.new do |s|
  s.name             = 'APIVerveCoinFlipper'
  s.version          = '1.2.3'
  s.summary          = 'Coin Flipper simulates random coin flips and records heads or tails outcomes with flip counts.'
  s.description      = <<-'DESC'
Coin Flipper simulates random coin flips and records heads or tails outcomes with flip counts. Paid plans can simulate multiple flips per request and calculate percentages, streak lengths, and fairness indicators.

This iOS/macOS SDK provides a convenient way to access the Coin Flipper from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/coinflipper?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/coinflipper-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveCoinFlipper/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
