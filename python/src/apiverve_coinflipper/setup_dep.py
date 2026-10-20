from setuptools import setup, find_packages

setup(
    name='apiverve_coinflipper',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Coin Flipper simulates random coin flips and records heads or tails outcomes with flip counts. Paid plans can simulate multiple flips per request and calculate percentages, streak lengths, and fairness indicators.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/coinflipper?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
