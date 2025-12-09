from setuptools import setup, find_packages

setup(
    name='apiverve_coinflipper',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Coin Flipper is a tool for simulating coin flips. It can flip multiple coins at once and provides statistics including heads/tails counts, percentages, streaks, and fairness analysis for probability experiments and gaming.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
