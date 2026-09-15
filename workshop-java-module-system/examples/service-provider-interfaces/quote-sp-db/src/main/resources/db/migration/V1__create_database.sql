CREATE TABLE quote (
    id      INT AUTO_INCREMENT NOT NULL,
    author  VARCHAR(32) NOT NULL,
    quote   VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO quote (author, quote) VALUES
  ('Nelson Mandela',       'The greatest glory in living lies not in never falling, but in rising every time we fall.'),
  ('Walt Disney',          'The way to get started is to quit talking and begin doing.'),
  ('Steve Jobs',           'Your time is limited, so don''t waste it living someone else''s life. Don''t be trapped by dogma - which is living with the results of other people''s thinking.'),
  ('Eleanor Roosevelt',    'If life were predictable it would cease to be life, and be without flavor.'),
  ('Oprah Winfrey',        'If you look at what you have in life, you''ll always have more. If you look at what you don''t have in life, you''ll never have enough.'),
  ('James Cameron',        'If you set your goals ridiculously high and it''s a failure, you will fail above everyone else''s success.'),
  ('John Lennon',          'Life is what happens when you''re busy making other plans.'),
  ('Lao Tzu',              'The journey of a thousand miles begins with one step.'),
  ('Friedrich Nietzsche',  'That which does not kill us makes us stronger.'),
  ('Joe Kennedy',          'When the going gets tough, the tough get going.'),
  ('Mahatma Gandhi',       'You must be the change you wish to see in the world.'),
  ('Mae West',             'You only live once, but if you do it right, once is enough.'),
  ('Robert H. Schuller',   'Tough times never last but tough people do.'),
  ('Stephen King',         'Get busy living or get busy dying.'),
  ('Henry Ford',           'Whether you think you can or you think you can''t, you''re right.'),
  ('Alrded Lord Tennyson', 'Tis better to have loved and lost than to have never loved at all.');
