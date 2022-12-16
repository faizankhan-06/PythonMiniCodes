def interpolation(initial, fianl, step):
    if step == 1:
        return [initial]
    return [initial+(fianl-initial)/(step-1)*i for i in range(step)]

test = interpolation(56,136,36)
print(test)